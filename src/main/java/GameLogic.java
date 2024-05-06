public class GameLogic {

    static boolean lt, lm, lb, ct, cm, cb, rt, rm, rb;
    static boolean lt2, lm2, lb2, ct2, cm2, cb2, rt2, rm2, rb2;

    static boolean p1moves[] = new boolean[9];
    static boolean p2moves[] = new boolean[9];



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

        for (int i = 0; i < 9; i++) {
            p1moves[i] = false;
            p2moves[i] = false;
        }


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
                p1moves[0] = true;
                break;
            case 2:
                ct = true;
                p1moves[1] = true;
                break;
            case 3:
                rt = true;
                p1moves[2] = true;
                break;
            case 4:
                lm = true;
                p1moves[3] = true;
                break;
            case 5:
                cm = true;
                p1moves[4] = true;
                break;
            case 6:
                rm = true;
                p1moves[5] = true;
                break;
            case 7:
                lb = true;
                p1moves[6] = true;
                break;
            case 8:
                cb = true;
                p1moves[7] = true;
                break;
            case 9:
                rb = true;
                p1moves[8] = true;
                break;
            default:
                throw new IndexOutOfBoundsException("not a valid move");
        }
    }

    static void playerTwoMove(int num) throws IndexOutOfBoundsException{
        switch (num) {
            case 1:
                lt2 = true;
                p2moves[0] = true;
                break;
            case 2:
                ct2 = true;
                p2moves[1] = true;
                break;
            case 3:
                rt2 = true;
                p2moves[2] = true;
                break;
            case 4:
                lm2 = true;
                p2moves[3] = true;
                break;
            case 5:
                cm2 = true;
                p2moves[4] = true;
                break;
            case 6:
                rm2 = true;
                p2moves[5] = true;
                break;
            case 7:
                lb2 = true;
                p2moves[6] = true;
                break;
            case 8:
                cb2 = true;
                p2moves[7] = true;
                break;
            case 9:
                rb2 = true;
                p2moves[8] = true;
                break;
            default:
                throw new IndexOutOfBoundsException("not a valid move");
        }
    }







}
