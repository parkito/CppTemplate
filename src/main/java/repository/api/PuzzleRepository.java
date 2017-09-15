package repository.api;

import entity.Puzzle;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public interface PuzzleRepository extends GenericRepository<Puzzle, Long> {

    Puzzle findPuzzleByTitle(String title);

}
