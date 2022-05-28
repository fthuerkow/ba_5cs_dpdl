public class Adress {//a
    private String name;
    private String strasse;
    private String ort;


    public Adress(String name, String strasse, String ort) {//b
        this.name = name;
        this.strasse = strasse;
        this.ort = ort;
    }


    public String getName() {//c
        return name;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getOrt() {
        return ort;
    }

    public String toString(Adress adress){//d
        String drei =  adress.name + "  " + adress.ort + "  " + adress.strasse;
        return drei;
    }
    public static void main(String[] args) {//e

        Adress[] a = new Adress[5];
        //f
        a[0] = new Adress("Name0", "Strasse0", "Königsberg");
        a[1] = new Adress("Name1", "Strasse1", "Danzig");
        a[2] = new Adress("Name2", "Strasse2", "Marienburg");
        a[3] = new Adress("Name3", "Strasse3", "Stettin");
        a[4] = new Adress("Name4", "Strasse4", "Breslau");

        Adress.print(a);//j

        int i = Adress.search(a, "Name4");
        System.out.println("Adresse gefunden am Index: " + i);

    }
    static void print(Adress[] a) {//g

        for (Adress adress : a) {

            System.out.println(adress);
        }
    }
    static int search(Adress[] a, String s) {//h

        int i = -1;
        String n = "";

        for (int j = 0; j < a.length; j++) {

            n = a[j].getName();

            if (n.contains(s)) {

                i = j;
            }
        }

        return i;
    }
}