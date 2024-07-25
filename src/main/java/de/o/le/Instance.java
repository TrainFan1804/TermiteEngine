package de.o.le;

/**
 * A instance represent the most used asset in an textadventure. The current 
 * place where the user's {@link Character} can be inside is an instance. Each
 * instance <b>may</b> contain one NPC's to talk with, secret to find, or item 
 * to use.
 * 
 * @author                              o.le
 * @version                             0.5
 * @since                               0.1
 */
public abstract class Instance implements InstanceAction {

    protected Game game;

    protected Instance(Game game) {

        this.game = game;
        this.game.setInstance(this);
    }
    
    @Override
    public abstract String display();

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
}
