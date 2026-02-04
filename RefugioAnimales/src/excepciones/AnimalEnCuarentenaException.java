package excepciones;

public class AnimalEnCuarentenaException extends Exception {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   public AnimalEnCuarentenaException(String mensaje) {
       super(mensaje);
   }
  
}
