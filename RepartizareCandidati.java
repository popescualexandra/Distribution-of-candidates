/*
INPUT AND OUTPUT EXAMPLE
Input:
7 6 1 3 1
1990431987655 7.10 3 ETTI CTI ETTI.X
1990431987654 8.30 1 ETTI.X
1990431987653 10.00 2 CTI CTI.X
1990431987674 6.45 4 ETTI CTI ETTI.X CTI.X
1990431987634 7.22 2 ETTI CTI
1990431987651 9.42 1 ETTI
1990431984634 9.98 2 ETTI.X CTI.X

Output:
ETTI
1990431987651 9.42
1990431987634 7.22
1990431987655 7.10
1990431987674 6.45

CTI
1990431987653 10.00

ETTI.X
1990431984634 9.98

CTI.X

Respinsi
1990431987654 8.30
*/

import java.util.*;

public class Main{
    public abstract static class Student{
        String cnp;
        double medie;
        int nrOptiuni;
        String o1, o2, o3, o4;
        @Override
        public String toString(){
            return String.format("%s %.2f", this.cnp, this.medie);
        }
    }
    
    public static class Student1 extends Student{
        final int nrOptiuni = 1;
        Student1(String cnp, double medie, String o1){
            this.cnp = cnp;
            this.medie = medie;
            this.o1 = o1;
        }
    }
    
    public static class Student2 extends Student{
        final int nrOptiuni = 2;
        Student2(String cnp, double medie, String o1, String o2){
            this.cnp = cnp;
            this.medie = medie;
            this.o1 = o1;
            this.o2 = o2;
        }
    }
    
    public static class Student3 extends Student{
        final int nrOptiuni = 3;
        Student3(String cnp, double medie, String o1, String o2, String o3){
            this.cnp = cnp;
            this.medie = medie;
            this.o1 = o1;
            this.o2 = o2;
            this.o3 = o3;
        }
    }
    
    public static class Student4 extends Student{
        final int nrOptiuni = 4;
        Student4(String cnp, double medie, String o1, String o2, String o3, String o4){
            this.cnp = cnp;
            this.medie = medie;
            this.o1 = o1;
            this.o2 = o2;
            this.o3 = o3;
            this.o4 = o4;
        }
    }
    
    public static class Ordonare implements Comparator<Student>{
        @Override
        public int compare(Student s1, Student s2){
            return s1.medie > s2.medie ? -1 : 1;
        }
    }
    
    public static void main(String [] args){
        ArrayList<Student> studenti = new ArrayList<Student>();
        ArrayList<Student> ETTI = new ArrayList<Student>();
        ArrayList<Student> Etaxa = new ArrayList<Student>();
        ArrayList<Student> CTI = new ArrayList<Student>();
        ArrayList<Student> Ctaxa = new ArrayList<Student>();
        //ArrayList<Student> Respinsi = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        String linie1 = sc.nextLine();
        String [] s1 = linie1.split(" ");
        int nrStudenti = Integer.parseInt(s1[0]);
        int nrETTI = Integer.parseInt(s1[1]);
        int nrETTIx = Integer.parseInt(s1[2]);
        int nrCTI = Integer.parseInt(s1[3]);
        int nrCTIx = Integer.parseInt(s1[4]);
        for(int i=0 ; i<nrStudenti ; i++){
            String linie2 = sc.nextLine();
            String [] s2 = linie2.split(" ");
            switch(s2[2]){
                case "1":
                    Student1 st1 = new Student1(s2[0], Double.parseDouble(s2[1]), s2[3]);
                    studenti.add(st1);
                break;
                case "2":
                    Student2 st2 = new Student2(s2[0], Double.parseDouble(s2[1]), s2[3], s2[4]);
                    studenti.add(st2);
                break;
                case "3":
                    Student3 st3 = new Student3(s2[0], Double.parseDouble(s2[1]), s2[3], s2[4], s2[5]);
                    studenti.add(st3);
                break;
                case "4":
                    Student4 st4 = new Student4(s2[0], Double.parseDouble(s2[1]), s2[3], s2[4], s2[5], s2[6]);
                    studenti.add(st4);
                break;
            }
        }
        Collections.sort(studenti, new Ordonare());
        for(int i=0 ; i<studenti.size() ; i++){
            if(studenti.get(i).o1.equals("ETTI") && ETTI.size()<nrETTI){
                ETTI.add(studenti.get(i));
                studenti.remove(i);
                i--;
            }else if(studenti.get(i).o1.equals("ETTI.X") && Etaxa.size()<nrETTIx){
                Etaxa.add(studenti.get(i));
                studenti.remove(i);
                i--;
            }else if(studenti.get(i).o1.equals("CTI") && CTI.size()<nrCTI){
                CTI.add(studenti.get(i));
                studenti.remove(i);
                i--;
            }else if(studenti.get(i).o1.equals("CTI.X") && Ctaxa.size()<nrCTIx){
                Ctaxa.add(studenti.get(i));
                studenti.remove(i);
                i--;
            }
        }
        for(int i=0 ; i<studenti.size() ; i++){
            if(studenti.get(i) instanceof Student2 || studenti.get(i) instanceof Student3 || studenti.get(i) instanceof Student4){
                if(studenti.get(i).o2.equals("ETTI") && ETTI.size()<nrETTI){
                    ETTI.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }else if(studenti.get(i).o2.equals("ETTI.X") && Etaxa.size()<nrETTIx){
                    Etaxa.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }else if(studenti.get(i).o2.equals("CTI") && CTI.size()<nrCTI){
                    CTI.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }else if(studenti.get(i).o2.equals("CTI.X") && Ctaxa.size()<nrCTIx){
                    Ctaxa.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }
            }
            
        }
        for(int i=0 ; i<studenti.size() ; i++){
            if(studenti.get(i) instanceof Student3 || studenti.get(i) instanceof Student4){
                if(studenti.get(i).o3.equals("ETTI") && ETTI.size()<nrETTI){
                    ETTI.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }else if(studenti.get(i).o3.equals("ETTI.X") && Etaxa.size()<nrETTIx){
                    Etaxa.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }else if(studenti.get(i).o3.equals("CTI") && CTI.size()<nrCTI){
                    CTI.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }else if(studenti.get(i).o3.equals("CTI.X") && Ctaxa.size()<nrCTIx){
                    Ctaxa.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }
            }
        }
        for(int i=0 ; i<studenti.size() ; i++){
            if(studenti.get(i) instanceof Student4){
                if(studenti.get(i).o4.equals("ETTI") && ETTI.size()<nrETTI){
                    ETTI.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }else if(studenti.get(i).o4.equals("ETTI.X") && Etaxa.size()<nrETTIx){
                    Etaxa.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }else if(studenti.get(i).o4.equals("CTI") && CTI.size()<nrCTI){
                    CTI.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }else if(studenti.get(i).o4.equals("CTI.X") && Ctaxa.size()<nrCTIx){
                    Ctaxa.add(studenti.get(i));
                    studenti.remove(i);
                    i--;
                }
            }
        }
        System.out.println("ETTI");
        for(Student i:ETTI){
            System.out.println(i.toString());
        }
        System.out.println("");
        System.out.println("CTI");
        for(Student i:CTI){
            System.out.println(i.toString());
        }
        System.out.println("");
        System.out.println("ETTI.X");
        for(Student i:Etaxa){
            System.out.println(i.toString());
        }
        System.out.println("");
        System.out.println("CTI.X");
        for(Student i:Ctaxa){
            System.out.println(i.toString());
        }
        System.out.println("");
        if(studenti.size()!=0){
            System.out.println("Respinsi");
            for(Student i:studenti){
                System.out.println(i.toString());
            }
        }
    }
}
