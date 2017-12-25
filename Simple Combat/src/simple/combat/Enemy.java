/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.combat;

/**
 *
 * @author Cen
 */
public class Enemy {
    private String name;
    private int level;
    
    private double hp;
    private double atk;
    private double def;
    
    private int exp;
    
    public Enemy(String name, int level)
    {
        this.name = name;
        this.level = level;
        this.hp = 10+level;
        this.atk = Math.abs(Math.random())*5+level*3;
        this.def = Math.abs(Math.random())*5+level*3;
        this.exp = 10+level*3;
    }
    
    public void applyDamage(double value)
    {
        this.hp-=value;
    }
    public int getExp()
    {
        return exp;
    }
    
    public String retName()
    {
        return this.name;
    }
    public double retHp()
    {
        return this.hp;
    }
    
    public double retAtk()
    {
        return this.atk;
    }
    
    public double retDef()
    {
        return this.def;
    }
}
