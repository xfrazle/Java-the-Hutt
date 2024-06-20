class Main {
    public static void main(String[] args) {
        StudentManager manage = new StudentManager();
        manage.add();
        manage.view();
        // manage.edit();

        System.out.println("SECOND PASS /////////////////////");

        manage.delete();
        manage.view();



    }
}