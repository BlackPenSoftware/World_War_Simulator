package com.blackpensoftware.world_war.generators;

import java.awt.Color;
import java.awt.Graphics;

import com.blackpensoftware.world_war.core.Hexagon;
import com.blackpensoftware.world_war.handlers.ColorSelector;

public class LandGenerator {
	Hexagon hex = new Hexagon();
	ColorSelector selector = new ColorSelector();	// Creates an accessible instance of the ColorSelector class
	
	public void genLand(Graphics g2d){
		int base_xPos = (hex.getSize() / 2) * -1;	// Centers the master Hexagon at 0 on the x axis 
		int base_yPos = (hex.getDiameter()) * -1;	// Centers the master Hexagon at 0 on the y axis
		int xPos = base_xPos;	// Sets the xPos variable to the base_xPos;
		int yPos = base_yPos;	// Sets the yPos variable to the base_yPos;
		
		for(int n = 0; n < hex.getNumberToGenX(); n++){	// For the number of hexagons to draw on the x axis
			for(int i = 0; i < hex.getNumberToGenX(); i++){	// For the number of hexagons to draw on the y axis
				selector.generateColor();	// Generate a color for the hexagon to be drawn 
				g2d.setColor(selector.getColor());	// Set the graphics color to the color that was generated
				hex.fillHex(g2d, xPos, yPos);	// Fill a hexagon at x, y
				g2d.setColor(Color.BLACK);	// Set the outline color to black 
				hex.drawHex(g2d, xPos, yPos);	// draw a hexagon over the drawn hexagon 
				xPos += hex.getSize() * 2 + hex.getSizeApothm() * 2;	// Move to the next line on the x axis
			}
			xPos = base_xPos;	// Reset the x axis
			yPos += hex.getHeight();	// Go to the next y axis line 
		}
		
		xPos = base_xPos + hex.getSize() + hex.getSizeApothm();		// Sets the new starting x point 
		yPos = base_yPos - hex.getDiameter();	// Sets the new starting y point
		
		for(int n = 0; n < hex.getNumberToGenY(); n++){		// For the number of hexagons to draw on the y 
			for(int i = 0; i < hex.getNumberToGenY(); i++){	// For the number of hexagons to draw on the x
				selector.generateColor();	// Generate the color for the next hexagon to be generated
				g2d.setColor(selector.hex_color);	// Sets the hexagon draw color to what was generated
				hex.fillHex(g2d, xPos, yPos);	// Fills a hexagon of that color
				g2d.setColor(Color.BLACK);	// Sets the outline color of the hexagon 
				hex.drawHex(g2d, xPos, yPos);	// Draws a hexagon on top of the pre-drawn hexagon 
				xPos += hex.getSizeApothm() * 2 + hex.getSize() * 2;	// Moves the xPos to the next xPos line 
			}
			xPos = base_xPos + hex.getSize() + hex.getSizeApothm();	// Resets the xPos
			yPos += hex.getHeight();	// Increments the yPos
		}
	}//End of genLand method
}// End of class
