package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
		
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturePiece = makeMove(source, target);
		return (ChessPiece)capturePiece;
	}
	
	private Piece makeMove(Position sourse, Position target) {
		Piece p = board.removePiece(sourse);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return (ChessPiece)capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			new ChessException("There is not piece on source position");
		}
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		
	}
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new Rook(board, Color.WHITE));
		
		placeNewPiece('c', 7, new Rook(board, Color.WHITE));
		placeNewPiece('c', 8, new Rook(board, Color.WHITE));
		placeNewPiece('d', 7, new Rook(board, Color.WHITE));
		placeNewPiece('e', 7, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new Rook(board, Color.WHITE));
		placeNewPiece('d', 8, new Rook(board, Color.WHITE));
		}
	

}

