package com.statemachine;

import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import com.statemachine.config.OrderEvents;
import com.statemachine.config.OrderStates;

public class StateChangeListener implements StateMachineListener<OrderStates, OrderEvents> {

    @Override
    public void stateChanged(State<OrderStates, OrderEvents> from, State<OrderStates, OrderEvents> to) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateChanged'");
    }

    @Override
    public void stateEntered(State<OrderStates, OrderEvents> state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateEntered'");
    }

    @Override
    public void stateExited(State<OrderStates, OrderEvents> state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateExited'");
    }

    @Override
    public void eventNotAccepted(Message<OrderEvents> event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eventNotAccepted'");
    }

    @Override
    public void transition(Transition<OrderStates, OrderEvents> transition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transition'");
    }

    @Override
    public void transitionStarted(Transition<OrderStates, OrderEvents> transition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transitionStarted'");
    }

    @Override
    public void transitionEnded(Transition<OrderStates, OrderEvents> transition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transitionEnded'");
    }

    @Override
    public void stateMachineStarted(StateMachine<OrderStates, OrderEvents> stateMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateMachineStarted'");
    }

    @Override
    public void stateMachineStopped(StateMachine<OrderStates, OrderEvents> stateMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateMachineStopped'");
    }

    @Override
    public void stateMachineError(StateMachine<OrderStates, OrderEvents> stateMachine, Exception exception) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateMachineError'");
    }

    @Override
    public void extendedStateChanged(Object key, Object value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extendedStateChanged'");
    }

    @Override
    public void stateContext(StateContext<OrderStates, OrderEvents> stateContext) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateContext'");
    }


}
