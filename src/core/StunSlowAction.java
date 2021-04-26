package core;

public class StunSlowAction implements StunSlowInterface {
    int stun_action = 0;
    int slow_action = 0;
    public void stun_effect(int i) {
        if(this.stun_action<i){
            this.stun_action = i;
        }
    }

    public void slow_effect(int i){
        if(this.slow_action < i) {
            this.slow_action = i;
        }
    }
}
