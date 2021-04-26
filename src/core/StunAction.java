package core;

public class StunAction implements StunInterface{
    int stun_action = 0;
    public void stun_effect(int i) {
        if(this.stun_action<i){
            this.stun_action = i;
        }
    }
}
