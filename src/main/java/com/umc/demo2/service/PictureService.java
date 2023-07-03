package com.umc.demo2.service;

import com.umc.demo2.domain.Picture;
import com.umc.demo2.handler.FileHandler;
import com.umc.demo2.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PictureService {

    private final PictureRepository boardRepository;

    private final FileHandler fileHandler;

    @Autowired
    public PictureService(PictureRepository boardRepository) {
        this.boardRepository = boardRepository;
        this.fileHandler = new FileHandler();
    }

    public Picture addBoard(
            Picture board,
            List<MultipartFile> files
    ) throws Exception {
        // 파일을 저장하고 그 Board 에 대한 list 를 가지고 있는다
        List<Picture> list = fileHandler.parseFileInfo(board.getId(), files);

        if (list.isEmpty()){
            // TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else{
            List<Picture> pictureBeans = new ArrayList<>();
            for (Picture boards : list) {
                pictureBeans.add(boardRepository.save(boards));
            }
        }

        return boardRepository.save(board);
    }

    public List<Picture> findBoards() {
        return boardRepository.findAll();
    }

    public Optional<Picture> findBoard(Long id) {
        return boardRepository.findById(id);
    }

}
