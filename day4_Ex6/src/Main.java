public class Main {
    public static <string> void main(String[] args) {

//Ex6
        String[]array={ "cat", "dog", "red", "is", "am" };
        int len=0;
        for (int i = 0; i < array.length; i++) {
            len = array[i].length();
            System.out.println( "the length of "+array[i] +"= "+len);
        }

        int max2=array[0].length();

        for(int i=0;i< array.length-1;i++)
        {
           if(array[i].length()<array[i+1].length())
               max2=array[i+1].length();


        }
        System.out.println("the longest length in this array : "+max2);

        for(int i=0;i< array.length-1;i++)
        {
            if(array[i].length()==max2)
                System.out.print(array[i]+" ");
        }

    }


        }

