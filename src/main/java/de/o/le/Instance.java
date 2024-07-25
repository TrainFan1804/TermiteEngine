package de.o.le;

/**
 * A instance represent the most used asset in an textadventure. The current 
 * place where the user's {@link Character} can be inside is an instance. Each
 * instance <b>may</b> contain one NPC's to talk with, secret to find, or item 
 * to use.
 * 
 * @author                              o.le
 * @version                             0.7
 * @since                               0.1
 */
public abstract class Instance implements InstanceAction {

    private InstanceState state;

    /**
     * This method will set the state of the instance.
     * 
     * @param state                     The new state of the instance.
     */
    void setState(InstanceState state) {

        this.state = state;
    }
    
    /**
     * Execute the action that belong to the saved state. 
     */
    void executeAction() {

        switch (state) {
            case TALK:
                this.talk();
                break;
            case SEARCH:
                this.search();
                break;
            case USE:
                this.use();
                break;
            case GO:
                this.go();
                break;
            case LEAVE:
                this.leave();
                break;
        }
    }

    @Override
    public void talk() {

        // if (this.npc != null) {

        //     this.npc.talk();
        // }
        System.out.println("You can't talk to anyone");
    }

    @Override
    public void search() {

        // if (this.secret != null) {

        //     this.secret.expose();
        // }
        System.out.println("There are no secrets");
    }

    @Override
    public void use() {
        
        // if (this.item != null) {

        //     this.item.useItem();
        // }
        System.out.println("There are no items");
    }

    @Override
    public void go() {
        
        System.out.println("You can't go to another instance");
    }

    @Override
    public void leave() {
        
        System.out.println("You can't leave this instance");
    }

    @Override
    public abstract String display();

    /**
     * This method is do something as soon as the player enter this instance.
     */
    public abstract void enter();
}
