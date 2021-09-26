package task3;

public class Matrix extends Line{
    public Matrix(int length) {
        super(length);
    }
    public Matrix(int row,int col){
        super(row *col);
    }
    protected String toSquareString(){
        String lineString = "\t";
        for(int i = 0;i<Monster.ROW;i++){
            for(int j = 0;j<Monster.COL;j++){
                lineString += positions[(i*Monster.ROW)+j].linable.toString();
            }
            lineString += "\n\t";
        }
        return lineString;
    }
    @Override
    public String toString() {
        return toSquareString();
    }
}
