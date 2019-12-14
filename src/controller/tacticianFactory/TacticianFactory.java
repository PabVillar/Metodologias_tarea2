package controller.tacticianFactory;

import model.Tactician;

import java.util.HashMap;

public class TacticianFactory {
    private static final HashMap<String, Tactician> tacticianMap = new HashMap<String,Tactician>();
    private static String name;

    /**
     * Sets the tactician's names
     * @param i
     *      The number of the player
     */
    public void setName(int i){
        this.name = "Player " + i;
    }

    /**
     *
     * @return the name of the tactician
     */
    public static String getName() {
        return name;
    }

    public static Tactician create(){
        return new Tactician(getName());
    }

    /**
     * Creates tacticians
     * @param name
     * @return a new tactician
     */
    public static Tactician getTactician(String name){
        Tactician tactician;
        if (tacticianMap.containsKey(name)){
           tactician = tacticianMap.get(name);
        }
        else{
            tactician = create();
            tacticianMap.put(name,tactician);
        }
        return tactician;
    }


}
