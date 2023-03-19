package exceptions;
//Si se ingresa un simbolo inválido
public class InvalidSymbolException extends Exception {
    public InvalidSymbolException() {
        super("El símbolo ingresado no es válido.");
    }
}
