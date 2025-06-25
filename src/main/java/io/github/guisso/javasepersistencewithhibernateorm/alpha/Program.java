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
package io.github.guisso.javasepersistencewithhibernateorm.alpha;

import io.github.guisso.javasepersistencewithhibernateorm.alpha.aluno.Aluno;
import io.github.guisso.javasepersistencewithhibernateorm.alpha.aluno.AlunoRepository;
import java.time.LocalDate;
import java.util.List;

/**
 * Runs tests of the "Alpha" version
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1
 * @since 0.1, 2025-06-25
 */
public class Program {

    public static void main(String[] args) {
        // Object to be persisted
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();

        // !!! ID should not be set!!!
        //aluno.setId(1234L);
//        
        a1.setMatricula(20250001);
        a1.setNome("Ana Zaira");
        a1.setNascimento(LocalDate.of(2000, 6, 1));
        
        a2.setMatricula(20250002);
        a2.setNome("Beatriz Yana");
        a2.setNascimento(LocalDate.of(2000, 10, 20));

        AlunoRepository repository = new AlunoRepository();

        // Persistence
        repository.save(a1);
        repository.save(a2);
        
//        +-----------+------------+----+--------------+
//        | matricula | nascimento | id | nome         |
//        +-----------+------------+----+--------------+
//        |  20250001 | 2000-06-01 |  1 | Ana Zaira    |
//        |  20250002 | 2000-10-20 |  2 | Beatriz Yana |
//        +-----------+------------+----+--------------+
//        
        System.out.println("> " + a1);
        System.out.println("> " + a2);
        
        // Object to be updated
        a1.setMatricula(987654);
        
        // Persistence
        repository.update(a1);
        
//        +-----------+------------+----+--------------+
//        | matricula | nascimento | id | nome         |
//        +-----------+------------+----+--------------+
//        |    987654 | 2000-06-01 |  1 | Ana Zaira    |
//        |  20250002 | 2000-10-20 |  2 | Beatriz Yana |
//        +-----------+------------+----+--------------+
//        
        System.out.println("> " + a1);
        System.out.println("> " + a2);
        
        List<Aluno> alunos = repository.findAll();
        
        for (Aluno aluno : alunos) {
            System.out.println(">> " + aluno);
        }
        
        // Note the idade, which is a value derived from the nascimento: null
        // How to resolve?
        // TODO Aluno needs adjustments
//        >> Aluno{id=1, matricula=987654, nome=Ana Zaira, nascimento=2000-06-01, idade=null}
//        >> Aluno{id=2, matricula=20250002, nome=Beatriz Yana, nascimento=2000-10-20, idade=null}
        
    }
}
