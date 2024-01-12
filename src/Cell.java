import java.awt.*;

public class Cell {
    private int age = 0;
    private boolean alive = false;
    private boolean hasBeenAlive = false;

    public void kill(){
        alive = false;
    }

    public void revive(){
        alive = true;
    }

    public boolean getState(){
        return alive;
    }

    public void ageUp(){
        age++;
    }

    public void hasBeenAlive(){
        hasBeenAlive = true;
    }

    public boolean getHasBeenAlive(){
        return hasBeenAlive;
    }

    public Color getCellColor(){
        if(age == 0 && alive){
            return Color.BLUE;
        }
        else if(age == 1){
            return Color.LIGHT_GRAY;
        }
        else if(age == 2){
            return Color.GREEN;
        }
        else if(age == 3){
            return Color.YELLOW;
        }
        else if(age == 4){
            return Color.ORANGE;
        }
        else if(age == 5){
            return Color.RED;
        }
        else if(!alive){
            return Color.WHITE;
        }
        else{
            return Color.BLACK;
        }
    }

}
