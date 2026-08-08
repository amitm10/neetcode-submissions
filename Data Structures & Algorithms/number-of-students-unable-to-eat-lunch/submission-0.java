class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
         //Circular = 0, Square =1
         //students.len = sandwiches.length
         //i=0 is top for Sanwiches this is stack(reverse stack)
         //j=0 is front of queue reverse quue
         int count0 = 0;//Circular Sandwich 
         int count1 = 0;//Square Sandwich
         for (int s : students) {
             if (s == 0) count0++;
             else count1++;
         }//Number of Circular and Square Sandwiches needed.
         
         for (int sandwich : sandwiches) {
             if (sandwich == 0) {
                 if (count0 > 0) count0--;
                 else return count1;
             } else {
                 if (count1 > 0) count1--;
                 else return count0;
             }
         }
         return 0;

         //if count of sandwich matches exactly with the preference then no student will go empty
    }
}