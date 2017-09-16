package com.karnov.crud.repository.api;

import com.karnov.crud.entity.Puzzle;
import com.karnov.crud.exception.RepositoryException;

import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public interface PuzzleRepository extends GenericRepository<Puzzle, Long> {

    Puzzle findPuzzleByTitle(String title) throws RepositoryException;

    List<Puzzle> findPuzzleByTitle(List<String> titles) throws RepositoryException;

}
