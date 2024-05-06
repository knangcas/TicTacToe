package ttt;

public class GameLogic {

    static boolean lt, lm, lb, ct, cm, cb, rt, rm, rb;
    static boolean lt2, lm2, lb2, ct2, cm2, cb2, rt2, rm2, rb2;



    void newGame() {
        lt = false;
        lm = false;
        lb = false;
        ct = false;
        cm = false;
        cb = false;
        rt = false;
        rm = false;
        rb = false;
        lt2 = false;
        lm2 = false;
        lb2 = false;
        ct2 = false;
        cm2 = false;
        cb2 = false;
        rt2 = false;
        rm2 = false;
        rb2 = false;


    }


    //8 possible solutions

    static boolean checkVictoryP1() {
        if (lt && lm && lb)
            return true;
        if (ct && cm && cb)
            return true;
        if (rt && rm && rb)
            return true;
        if (lt && ct && rt)
            return true;
        if (lm && cm && rm)
            return true;
        if (lb && cb && rb)
            return true;
        if (lt && cm && rb)
            return true;
        if (lb && cm && rt)
            return true;

        return false;
    }

    static boolean checkVictoryP2() {
        if (lt2 && lm2 && lb2)
            return true;
        if (ct2 && cm2 && cb2)
            return true;
        if (rt2 && rm2 && rb2)
            return true;
        if (lt2 && ct2 && rt2)
            return true;
        if (lm2 && cm2 && rm2)
            return true;
        if (lb2 && cb2 && rb2)
            return true;
        if (lt2 && cm2 && rb2)
            return true;
        if (lb2 && cm2 && rt2)
            return true;

        return false;
    }


   static void playerOneMove(int num) throws IndexOutOfBoundsException{
        switch (num) {
            case 1:
                lt = true;
                break;
            case 2:
                ct = true;
                break;
            case 3:
                rt = true;
                break;
            case 4:
                lm = true;
                break;
            case 5:
                cm = true;
                break;
            case 6:
                rm = true;
                break;
            case 7:
                lb = true;
                break;
            case 8:
                cb = true;
                break;
            case 9:
                rb = true;
                break;
            default:
                throw new IndexOutOfBoundsException("not a valid move");
        }
    }

    static void playerTwoMove(int num) throws IndexOutOfBoundsException{
        switch (num) {
            case 1:
                lt2 = true;
                break;
            case 2:
                ct2 = true;
                break;
            case 3:
                rt2 = true;
                break;
            case 4:
                lm2 = true;
                break;
            case 5:
                cm2 = true;
                break;
            case 6:
                rm2 = true;
                break;
            case 7:
                lb2 = true;
                break;
            case 8:
                cb2 = true;
                break;
            case 9:
                rb2 = true;
                break;
            default:
                throw new IndexOutOfBoundsException("not a valid move");
        }
    }







}
