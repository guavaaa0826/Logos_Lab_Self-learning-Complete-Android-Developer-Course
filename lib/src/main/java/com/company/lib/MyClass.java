package com.company.lib;

import java.util.Random;

public class MyClass {

    // The following is the main method.
    public static void main(String[] args) {
        failure fm;
        failure ed;

        Random random = new Random();
        fm = new failureManagement(random.nextInt(101));
        ed = new emotionalDamage(random.nextInt(101));

        fm.whoAreYou();
        ed.whoAreYou();
    }
}

abstract class failure {
    // The following are the variables of failure.
    protected int score;
    protected boolean isFailure;

    // The following are some methods with function overloading example.
    public failure() {
        score = 0;
    }
    public failure(int score) {
        this.score = score;
    }

    public void areYouFailure() {
        if (score == 100) {
            isFailure = false;
        } else {
            isFailure = true;
        }
    };
    public abstract void whoAreYou();
}

class failureManagement extends failure {
    protected String therapy;

    public failureManagement() {
        super();
        therapy = "Beijing corn";
    }
    public failureManagement(int score) {
        super(score);
        therapy = "Beijing corn";
    }

    // This is the method override from the parent class.
    @Override
    public void whoAreYou() {
        System.out.print("You have " + score + " points on test.\n");
        // This is the method overloaded from the parent class.
        areYouFailure();
        if (isFailure) {
            System.out.print("Go get some " + therapy + " lah.\n");
        }
    }
}

class emotionalDamage extends failure {
    protected String comment;

    public emotionalDamage() {
        super();
        comment = "You are a FAILURE!";
    }
    public emotionalDamage(int score) {
        super(score);
        comment = "You are a FAILURE!";
    }

    @Override
    public void whoAreYou() {
        System.out.print("You have " + score + " points on test.\n");
        areYouFailure();
        if (isFailure) {
            System.out.print(comment + "\n");
        }
    }
}