/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturalProductDbGui;

/**
 * creates a NpDbEntry object that can contain the superclass class and Subclass or the id,smiles superclass class and subclass.
 * has get and set methods for all the variables.
 * @author ozing003
 */
public class NpDbEntry {

    public NpDbEntry(String npSuperClass, String npclass, String npSubClass) {

        this.npSuperClass = npSuperClass;
        this.npClass = npclass;
        this.npSubClass = npSubClass;
    }

    public NpDbEntry(String structure_id, String smile, String npSuperClass, String npClass, String npSubClass) {
        this.structure_id = structure_id;
        this.smile = smile;
        this.npSuperClass = npSuperClass;
        this.npClass = npClass;
        this.npSubClass = npSubClass;
    }
    
    private String structure_id;

    public String getStructure_id() {
        return structure_id;
    }

    public void setStructure_id(String structure_id) {
        this.structure_id = structure_id;
    }

    public String getSmile() {
        return smile;
    }

    public void setSmile(String smile) {
        this.smile = smile;
    }
    private String smile;
    private String npSuperClass;
    private String npClass;
    private String npSubClass;



    public String getNpSuperClass() {
        return npSuperClass;
    }

    public void setNpSuperClass(String npSuperClass) {
        this.npSuperClass = "super|" + npSuperClass;
    }

    public String getNpClass() {
        return npClass;
    }

    public void setNpClass(String npClass) {
        this.npClass = "class|" + npClass;
    }

    public String getNpSubClass() {
        return npSubClass;
    }

    public void setNpSubClass(String npSubClass) {
        this.npSubClass = "sub|" + npSubClass;
    }
}
