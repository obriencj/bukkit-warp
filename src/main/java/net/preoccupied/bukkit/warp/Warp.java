package net.preoccupied.bukkit.warp;


import com.avaje.ebean.validation.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import net.preoccupied.bukkit.permissions.PermissionCheck;



@Entity()
@Table(name="net_preoccupied_bukkit_warp")
public class Warp {

    @Id
    private int id;

    @NotNull
    private String name = null;

    private String destination = null;

    private String permission = null;

    @Transient
    private PermissionCheck permissionCheck = null;

    private String output_w = null;
    private int output_x = 0;
    private int output_y = 0;
    private int output_z = 0;
    private float outputYaw = 0.0f;
    
    private String input_a_w = null;
    private int input_a_x = 0;
    private int input_a_y = 0;
    private int input_a_z = 0;
    
    private String input_b_w = null;
    private int input_b_x = 0;
    private int input_b_y = 0;
    private int input_b_z = 0;
    
    private float inputYaw = 0.0f;
    

    public void setName(String name) {
	this.name = name;
    }


    public String getName() {
	return this.name;
    }


    public void setDestination(String name) {
	this.destination = name;
    }


    public String getDestination() {
	return this.destination;
    }


    public void setPermission(String permission) {
	this.permission = permission;
	this.permissionCheck = PermissionCheck.forNode(permission);
    }


    public String getPermission() {
	return this.permission;  
    }


    public boolean checkPermission(Player player) {
	if(permissionCheck == null) {
	    permissionCheck = new PermissionCheck("preoccupied.warp.portal." + this.name);
	}
	return permissionCheck.check(player);
    }


    private static Location asLocation(String w, int x, int y, int z) {
	if (w == null) return null;

	World world = Bukkit.getServer().getWorld(w);
	if (world == null) return null;

	return new Location(world, (double) x + 0.5d, (double) y, (double) z + 0.5d);
    }


    public Location getInputA() {
	return asLocation(input_a_w, input_a_x, input_a_y, input_a_z);
    }


    public void setInputA(Location l) {
	if(l != null) {
	    setInput_a_w(l.getWorld().getName());
	    setInput_a_x(l.getBlockX());
	    setInput_a_y(l.getBlockY());
	    setInput_a_z(l.getBlockZ());

	} else {
	    setInput_a_w(null);
	    setInput_a_x(0);
	    setInput_a_y(0);
	    setInput_a_z(0);
	}
    }


    public Location getInputB() {
	return asLocation(input_b_w, input_b_x, input_b_y, input_b_z);
    }


    public void setInputB(Location l) {
	if(l != null) {
	    setInput_b_w(l.getWorld().getName());
	    setInput_b_x(l.getBlockX());
	    setInput_b_y(l.getBlockY());
	    setInput_b_z(l.getBlockZ());

	} else {
	    setInput_b_w(null);
	    setInput_b_x(0);
	    setInput_b_y(0);
	    setInput_b_z(0);
	}
    }


    public float getInputYaw() {
	return inputYaw;
    }


    public void setInputYaw(float yaw) {
	this.inputYaw = yaw;
    }

    
    public float getOutputYaw() {
	return outputYaw;
    }


    public void setOutputYaw(float yaw) {
	this.outputYaw = yaw;
    }


    public Location getOutput() {
	Location l =  asLocation(output_w, output_x, output_y, output_z);
	l.setYaw(outputYaw);
	return l;
    }


    public void setOutput(Location l) {
	if(l != null) {
	    setOutput_w(l.getWorld().getName());
	    setOutput_x(l.getBlockX());
	    setOutput_y(l.getBlockY());
	    setOutput_z(l.getBlockZ());
	    setOutputYaw(l.getYaw());

	} else {
	    setOutput_w(null);
	    setOutput_x(0);
	    setOutput_y(0);
	    setOutput_z(0);
	}
    }


    // the following are all just for bean usage

    public void setId(int id) {
	this.id = id;
    }


    public int getId() {
	return this.id;
    }


    public void setOutput_w(String w) {
	this.output_w = w;
    }


    public String getOutput_w() {
	return this.output_w;
    }


    public void setOutput_x(int i) {
	this.output_x = i;
    }


    public int getOutput_x() {
	return this.output_x;
    }


    public void setOutput_y(int i) {
	this.output_y = i;
    }


    public int getOutput_y() {
	return this.output_y;
    }


    public void setOutput_z(int i) {
	this.output_z = i;
    }


    public int getOutput_z() {
	return this.output_z;
    }


    public void setInput_a_w(String w) {
	this.input_a_w = w;
    }


    public String getInput_a_w() {
	return this.input_a_w;
    }


    public void setInput_a_x(int i) {
	this.input_a_x = i;
    }


    public int getInput_a_x() {
	return this.input_a_x;
    }


    public void setInput_a_y(int i) {
	this.input_a_y = i;
    }


    public int getInput_a_y() {
	return this.input_a_y;
    }


    public void setInput_a_z(int i) {
	this.input_a_z = i;
    }


    public int getInput_a_z() {
	return this.input_a_z;
    }


    public void setInput_b_w(String w) {
	this.input_b_w = w;
    }


    public String getInput_b_w() {
	return this.input_b_w;
    }


    public void setInput_b_x(int i) {
	this.input_b_x = i;
    }


    public int getInput_b_x() {
	return this.input_b_x;
    }


    public void setInput_b_y(int i) {
	this.input_b_y = i;
    }


    public int getInput_b_y() {
	return this.input_b_y;
    }


    public void setInput_b_z(int i) {
	this.input_b_z = i;
    }


    public int getInput_b_z() {
	return this.input_b_z;
    }

}


/* The end. */
