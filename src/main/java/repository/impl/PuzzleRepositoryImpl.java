package repository.impl;

import entity.Puzzle;
import exception.RepositoryException;
import repository.api.PuzzleRepository;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class PuzzleRepositoryImpl extends GenericRepositoryImpl<Puzzle, Long> implements PuzzleRepository {

    @Override
    public Puzzle findPuzzleByTitle(String title) throws RepositoryException {
        try {
            return (Puzzle) entityManager
                    .createQuery("select p from Puzzle p where p.title=:title")
                    .setParameter("title", title)
                    .getSingleResult();
        } catch (PersistenceException ex) {
            throw new RepositoryException("Entity wasn't found: " + title, ex);
        }
    }

    @Override
    public List<Puzzle> findPuzzleByTitle(List<String> titles) throws RepositoryException {
        try {
            return entityManager
                    .createQuery("select p from Puzzle p where p.title in :titles")
                    .setParameter("titles", titles)
                    .getResultList();
        } catch (PersistenceException ex) {
            throw new RepositoryException("Entities weren't found: " + titles, ex);
        }
    }

}
