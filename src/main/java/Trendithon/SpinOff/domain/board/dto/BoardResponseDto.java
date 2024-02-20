package Trendithon.SpinOff.domain.board.dto;

import Trendithon.SpinOff.domain.board.entity.Board;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class BoardResponseDto {
    private Long boardId;
    private String boardTitle;
    private String boardContext;
    private Long boardLike;
    private List<String> imageUrl;
    private String writer;

    public static BoardResponseDto toDTO(Board board) throws JsonProcessingException {
        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setBoardId(board.getBoard_id());
        boardResponseDto.setBoardTitle(board.getBoard_title());
        boardResponseDto.setBoardContext(board.getBoard_context());
        boardResponseDto.setBoardLike(board.getBoardLike());
        boardResponseDto.setImageUrl(toList(board.getImage_url()));
        boardResponseDto.setWriter(board.getWriter());
        return boardResponseDto;
    }

    public static List<String> toList(String imageUrl) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(imageUrl, new TypeReference<List<String>>() {});
    }
}
