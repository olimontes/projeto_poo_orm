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
package io.github.guisso.javasepersistencewithhibernateorm.alpha.aluno;

import io.github.guisso.javasepersistencewithhibernateorm.alpha.repository.DataSourceFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * Repository actions for Aluno entity
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1
 * @since 0.1, 2025-06-25
 */
public class AlunoRepository {

    public Long save(Aluno aluno) {
        EntityManager em = DataSourceFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (aluno.getId() == null) {
                em.persist(aluno);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
                em.close();
                throw e;
            }
        } finally {
            em.close();
        }

        return aluno.getId();
    }

    public Long update(Aluno aluno) {

        EntityManager em = DataSourceFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (aluno.getId() != null) {
                em.merge(aluno);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
                em.close();
                throw e;
            }
        } finally {
            em.close();
        }

        return aluno.getId();
    }

    public List<Aluno> findAll() {

        EntityManager em = DataSourceFactory.getEntityManager();

        try {
            TypedQuery<Aluno> query
                    = em.createQuery(
                            "SELECT a FROM Aluno a",
                            Aluno.class
                    );
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
