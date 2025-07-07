/*
 * Copyright (C) 2025 Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.guisso.javasepersistencewithhibernateorm.beta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.query.Query;

/**
 * Generic repository
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1
 * @param <T> Type of objects
 * @since 0.1, Jul 7, 2025
 */
public abstract class Repository<T extends ProjectEntity>
        implements IRepository<T> {

    @Override
    public Long saveOrUpdate(T e) {
        EntityManager em = DataSourceFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (e.getId() == null || e.getId() == 0) {
                em.persist(e);
            } else {
                em.merge(e);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
                em.close();
                throw ex;
            }
        } finally {
            em.close();
        }

        return e.getId();
    }

    @Override
    public List<T> findAll() {
        EntityManager em = DataSourceFactory.getEntityManager();

        try {
            TypedQuery<T> query = em.createQuery(
                    // Polimorphism applied
                    getJpqlFindAll(),
                    (Class<T>) ((ParameterizedType) getClass()
                            .getGenericSuperclass())
                            .getActualTypeArguments()[0]);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public T findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(T e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
