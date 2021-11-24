package baseball;


class ThreeDifferentDigits{
    private String[] ThreeDifferentDigits;

    String[] getDigits(){
        return ThreeDifferentDigits;
    }

    ThreeDifferentDigits(){
        init3DiffDigits();
    }

    void init3DiffDigits(){
        ThreeDifferentDigits = new String[3];
        int[] arr = getShuffledNumArr();

        for (int i=0; i<3; i++){
            ThreeDifferentDigits[i] = Integer.toString(arr[i]);
        }
    }

    int[] getShuffledNumArr(){
        int[] arr = {1,2,3,4,5,6,7,8,9};

        for (int i=0; i<25; i++){
            int rand = (int)(Math.random()*9);
            int temp = arr[rand];
            arr[rand] = arr[0];
            arr[0] = temp;
        }

        return arr;
    }
}