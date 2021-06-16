/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DTO.Aplicante;
import DTO.BecaAplicante;
import DTO.Becaa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author german
 */
public class BecaAplicanteJpaController implements Serializable {

    public BecaAplicanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BecaAplicante becaAplicante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aplicante codaplicante = becaAplicante.getCodaplicante();
            if (codaplicante != null) {
                codaplicante = em.getReference(codaplicante.getClass(), codaplicante.getCedula());
                becaAplicante.setCodaplicante(codaplicante);
            }
            Becaa codbeca = becaAplicante.getCodbeca();
            if (codbeca != null) {
                codbeca = em.getReference(codbeca.getClass(), codbeca.getCodigoBeca());
                becaAplicante.setCodbeca(codbeca);
            }
            em.persist(becaAplicante);
            if (codaplicante != null) {
                codaplicante.getBecaAplicanteList().add(becaAplicante);
                codaplicante = em.merge(codaplicante);
            }
            if (codbeca != null) {
                codbeca.getBecaAplicanteList().add(becaAplicante);
                codbeca = em.merge(codbeca);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BecaAplicante becaAplicante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BecaAplicante persistentBecaAplicante = em.find(BecaAplicante.class, becaAplicante.getCodigo());
            Aplicante codaplicanteOld = persistentBecaAplicante.getCodaplicante();
            Aplicante codaplicanteNew = becaAplicante.getCodaplicante();
            Becaa codbecaOld = persistentBecaAplicante.getCodbeca();
            Becaa codbecaNew = becaAplicante.getCodbeca();
            if (codaplicanteNew != null) {
                codaplicanteNew = em.getReference(codaplicanteNew.getClass(), codaplicanteNew.getCedula());
                becaAplicante.setCodaplicante(codaplicanteNew);
            }
            if (codbecaNew != null) {
                codbecaNew = em.getReference(codbecaNew.getClass(), codbecaNew.getCodigoBeca());
                becaAplicante.setCodbeca(codbecaNew);
            }
            becaAplicante = em.merge(becaAplicante);
            if (codaplicanteOld != null && !codaplicanteOld.equals(codaplicanteNew)) {
                codaplicanteOld.getBecaAplicanteList().remove(becaAplicante);
                codaplicanteOld = em.merge(codaplicanteOld);
            }
            if (codaplicanteNew != null && !codaplicanteNew.equals(codaplicanteOld)) {
                codaplicanteNew.getBecaAplicanteList().add(becaAplicante);
                codaplicanteNew = em.merge(codaplicanteNew);
            }
            if (codbecaOld != null && !codbecaOld.equals(codbecaNew)) {
                codbecaOld.getBecaAplicanteList().remove(becaAplicante);
                codbecaOld = em.merge(codbecaOld);
            }
            if (codbecaNew != null && !codbecaNew.equals(codbecaOld)) {
                codbecaNew.getBecaAplicanteList().add(becaAplicante);
                codbecaNew = em.merge(codbecaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = becaAplicante.getCodigo();
                if (findBecaAplicante(id) == null) {
                    throw new NonexistentEntityException("The becaAplicante with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BecaAplicante becaAplicante;
            try {
                becaAplicante = em.getReference(BecaAplicante.class, id);
                becaAplicante.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The becaAplicante with id " + id + " no longer exists.", enfe);
            }
            Aplicante codaplicante = becaAplicante.getCodaplicante();
            if (codaplicante != null) {
                codaplicante.getBecaAplicanteList().remove(becaAplicante);
                codaplicante = em.merge(codaplicante);
            }
            Becaa codbeca = becaAplicante.getCodbeca();
            if (codbeca != null) {
                codbeca.getBecaAplicanteList().remove(becaAplicante);
                codbeca = em.merge(codbeca);
            }
            em.remove(becaAplicante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BecaAplicante> findBecaAplicanteEntities() {
        return findBecaAplicanteEntities(true, -1, -1);
    }

    public List<BecaAplicante> findBecaAplicanteEntities(int maxResults, int firstResult) {
        return findBecaAplicanteEntities(false, maxResults, firstResult);
    }

    private List<BecaAplicante> findBecaAplicanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BecaAplicante.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public BecaAplicante findBecaAplicante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BecaAplicante.class, id);
        } finally {
            em.close();
        }
    }

    public int getBecaAplicanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BecaAplicante> rt = cq.from(BecaAplicante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
