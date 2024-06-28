class Main {
    public static void main(String[] args) {

        StudentManager manage = new StudentManager();
        // manage.view();
        // manage.edit();


        // manage.delete();
        // manage.view();        
        // manage.edit("198012345");
        
        // System.out.println("SECOND PASS /////////////////////");

        manage.add();
        manage.view();
        System.out.println("SECOND PASS /////////////////////");
        manage.edit("201812345");
        manage.view();

        manage.edit("201812345");
        manage.view();
    }
}

// 201812763
// 201812345
// 198012345