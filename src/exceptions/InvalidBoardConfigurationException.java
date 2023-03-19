package exceptions;
// Si se ingresa escaleras y serpientes mayores que el número total de casillas
public class InvalidBoardConfigurationException extends Exception {
    public InvalidBoardConfigurationException() {
        super("El número de escaleras y serpientes debe ser menor al número total de casillas.");
    }
}

