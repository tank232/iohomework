public enum Menu{

    WRITE(1){
        @Override
        public String toString(){
            return "Запись в файлы. Выбop 1" ; }},
    FIND(2){
        @Override
        public String toString(){
            return "Поиск в файлах. Выбop 2" ; }},
    EXIT(-1){
        @Override
        public String toString(){
            return "Выход. Выбop -1" ; }};

    private Integer id;

     Menu(Integer id) {
         this.id=id;

    }

   public static Menu getMenu(Integer id)
   {

       for(Menu menuValue: Menu.values())
       {
           if(id==menuValue.id)
               return menuValue;
           // System.out.println(menuValue.toString());
       }
       return null;
   }


    @Override
    public String toString(){
        return "";
    }

}
