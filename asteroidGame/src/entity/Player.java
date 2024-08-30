package entity;

import main.GamePanel;
import main.KeyHandler;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 2;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/fist_U0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/fist_U1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/fist_D0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/fist_D1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/fist_L0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/fist_L1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/fist_R0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/fist_R1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // Set Direction
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
                worldY -= speed;
            } else if (keyH.downPressed == true) {
                direction = "down";
                worldY += speed;
            } else if (keyH.leftPressed == true) {
                direction = "left";
                worldX -= speed;
            } else if (keyH.rightPressed == true) {
                direction = "right";
                worldX += speed;
            }
//         Change sprite every 10 frames
//            spriteCounter++;
//            if(spriteCounter > 10) {
//                if (spriteNum == 1) {
//                    spriteNum = 2;
//                } else if (spriteNum == 2) {
//                    spriteNum = 1;
//                }
//                spriteCounter = 0;
//            }
        }

    }
        public void draw (Graphics2D g2) {
            BufferedImage image = null;
            // swap sprite based on direction
            switch (direction) {
                case "up":
                    image = up1;
//                    if (spriteNum == 1) {
//                        image = up1;
//                    }
//                    if (spriteNum == 2) {
//                        image = up2;
//                    }
                    break;
                case "down":
                    image = down1;
//                    if (spriteNum == 1) {
//                        image = down1;
//                    }
//                    if (spriteNum == 2) {
//                        image = down2;
//                    }
                    break;
                case "left":
                    image = left1;
//                    if (spriteNum == 1) {
//                        image = left1;
//                    }
//                    if (spriteNum == 2) {
//                        image = left2;
//                    }
                    break;
                case "right":
                    image = right1;
//                    if (spriteNum == 1) {
//                        image = right1;
//                    }
//                    if (spriteNum == 2) {
//                        image = right2;
//                    }
                    break;
            }
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
