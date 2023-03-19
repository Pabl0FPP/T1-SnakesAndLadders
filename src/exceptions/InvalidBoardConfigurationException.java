package exceptions;
// Si se ingresa escaleras y serpientes mayores que el número de filas y columnas
public class InvalidBoardConfigurationException extends Exception {
    public InvalidBoardConfigurationException() {
        super("El número de escaleras y serpientes debe ser menor al número de filas y columnas.");
    }
}

