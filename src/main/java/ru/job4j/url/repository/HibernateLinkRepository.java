package ru.job4j.url.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.url.model.Link;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Класс - реализация репозитория Link с использованием Hibernate
 */
@Repository
@AllArgsConstructor
public class HibernateLinkRepository implements LinkRepository {

    /**
     * На данный объект мы будем делегировать выполнение команд, передавая в аргументы его методов
     * необходимые запросы и параметры
     */
    private final CrudRepository crudRepository;

    /**
     * Поиск всех ссылок
     */
    @Override
    public List<Link> findAll() {
        return new ArrayList<>();
    }

    /**
     * Поиск Link по url
     * @param url - строка содержащая url объекта Link
     * @return Optional найденного объекта Link или пустой Optional
     */
    @Override
    public Optional<Link> findByUrl(String url) {
        return crudRepository.optional("from Link as l where l.url = :fUrl", Link.class,
                Map.of("fUrl", url));
    }

    /**
     * Поиск Link по key - зашифрованной ссылке
     * @param key - строка содержащая зашифрованную ссылку объекта Link
     * @return Optional найденного объекта Link или пустой Optional
     */
    @Override
    public Optional<Link> findByKey(String key) {
        return crudRepository.optional("from Link as l where l.key = :fKey", Link.class,
                Map.of("fKey", key));
    }

    /**
     * Добавить ссылку.
     * @param link - объект Link
     * @return объект Link с присвоенным сгенерированным id
     */

    @Override
    public Link add(Link link) {
        crudRepository.run(session -> session.persist(link));
        return link;
    }
}
