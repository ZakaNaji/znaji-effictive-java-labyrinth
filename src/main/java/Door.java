public class Door {

    private String doorShape;
    private boolean isOpen;

    public Door(String shape, boolean isOpen){
        this.doorShape = shape;
        this.isOpen = isOpen;
    }

    public boolean doorIsOpen(){
        return isOpen;
    }

}
