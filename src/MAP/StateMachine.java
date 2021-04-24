import java.util.HashMap;
import java.util.Map;

public class StateMachine {
    /*FIELD*/
    private HashMap<String, IState> mStates = new HashMap<String, IState>();
    private IState currentstate;

    /*METHODS*/
    //constructor
    public StateMachine(IState startingstate){
        currentstate = startingstate;
    }

    public void update(){
        currentstate.update();
    }

    public void render(){
        currentstate.render();
    }
    
    public void change(String namastate){
        currentstate.exit();
        currentstate = mStates.get(namastate);
        currentstate.enter();
    }

    public void add(String namastate, IState state){
        mStates.put(namastate, state);
    }
}
