package exceptions;
//Si el tamaño (columnas o filas) es 0 o menor a 0
public class InvalidBoardSizeException extends RuntimeException {
    public InvalidBoardSizeException() {
        super("El tamaño del tablero debe ser un número entero mayor que cero");
    }
}
