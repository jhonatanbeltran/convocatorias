/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DTO.BecaAplicante;
import DTO.Becaa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author german
 */
public class BecaaJpaController implements Serializable {

    public BecaaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Becaa becaa) throws PreexistingEntityException, Exception {
        if (becaa.getBecaAplicanteList() == null) {
            becaa.setBecaAplicanteList(new ArrayList<BecaAplicante>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<BecaAplicante> attachedBecaAplicanteList = new ArrayList<BecaAplicante>();
            for (BecaAplicante becaAplicanteListBecaAplicanteToAttach : becaa.getBecaAplicanteList()) {
                becaAplicanteListBecaAplicanteToAttach = em.getReference(becaAplicanteListBecaAplicanteToAttach.getClass(), becaAplicanteListBecaAplicanteToAttach.getCodigo());
                attachedBecaAplicanteList.add(becaAplicanteListBecaAplicanteToAttach);
            }
            becaa.setBecaAplicanteList(attachedBecaAplicanteList);
            em.persist(becaa);
            for (BecaAplicante becaAplicanteListBecaAplicante : becaa.getBecaAplicanteList()) {
                Becaa oldCodbecaOfBecaAplicanteListBecaAplicante = becaAplicanteListBecaAplicante.getCodbeca();
                becaAplicanteListBecaAplicante.setCodbeca(becaa);
                becaAplicanteListBecaAplicante = em.merge(becaAplicanteListBecaAplicante);
                if (oldCodbecaOfBecaAplicanteListBecaAplicante != null) {
                    oldCodbecaOfBecaAplicanteListBecaAplicante.getBecaAplicanteList().remove(becaAplicanteListBecaAplicante);
                    oldCodbecaOfBecaAplicanteListBecaAplicante = em.merge(oldCodbecaOfBecaAplicanteListBecaAplicante);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBecaa(becaa.getCodigoBeca()) != null) {
                throw new PreexistingEntityException("Becaa " + becaa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Becaa becaa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Becaa persistentBecaa = em.find(Becaa.class, becaa.getCodigoBeca());
            List<BecaAplicante> becaAplicanteListOld = persistentBecaa.getBecaAplicanteList();
            List<BecaAplicante> becaAplicanteListNew = becaa.getBecaAplicanteList();
            List<String> illegalOrphanMessages = null;
            for (BecaAplicante becaAplicanteListOldBecaAplicante : becaAplicanteListOld) {
                if (!becaAplicanteListNew.contains(becaAplicanteListOldBecaAplicante)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain BecaAplicante " + becaAplicanteListOldBecaAplicante + " since its codbeca field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<BecaAplicante> attachedBecaAplicanteListNew = new ArrayList<BecaAplicante>();
            for (BecaAplicante becaAplicanteListNewBecaAplicanteToAttach : becaAplicanteListNew) {
                becaAplicanteListNewBecaAplicanteToAttach = em.getReference(becaAplicanteListNewBecaAplicanteToAttach.getClass(), becaAplicanteListNewBecaAplicanteToAttach.getCodigo());
                attachedBecaAplicanteListNew.add(becaAplicanteListNewBecaAplicanteToAttach);
            }
            becaAplicanteListNew = attachedBecaAplicanteListNew;
            becaa.setBecaAplicanteList(becaAplicanteListNew);
            becaa = em.merge(becaa);
            for (BecaAplicante becaAplicanteListNewBecaAplicante : becaAplicanteListNew) {
                if (!becaAplicanteListOld.contains(becaAplicanteListNewBecaAplicante)) {
                    Becaa oldCodbecaOfBecaAplicanteListNewBecaAplicante = becaAplicanteListNewBecaAplicante.getCodbeca();
                    becaAplicanteListNewBecaAplicante.setCodbeca(becaa);
                    becaAplicanteListNewBecaAplicante = em.merge(becaAplicanteListNewBecaAplicante);
                    if (oldCodbecaOfBecaAplicanteListNewBecaAplicante != null && !oldCodbecaOfBecaAplicanteListNewBecaAplicante.equals(becaa)) {
                        oldCodbecaOfBecaAplicanteListNewBecaAplicante.getBecaAplicanteList().remove(becaAplicanteListNewBecaAplicante);
                        oldCodbecaOfBecaAplicanteListNewBecaAplicante = em.merge(oldCodbecaOfBecaAplicanteListNewBecaAplicante);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = becaa.getCodigoBeca();
                if (findBecaa(id) == null) {
                    throw new NonexistentEntityException("The becaa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Becaa becaa;
            try {
                becaa = em.getReference(Becaa.class, id);
                becaa.getCodigoBeca();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The becaa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<BecaAplicante> becaAplicanteListOrphanCheck = becaa.getBecaAplicanteList();
            for (BecaAplicante becaAplicanteListOrphanCheckBecaAplicante : becaAplicanteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Becaa (" + becaa + ") cannot be destroyed since the BecaAplicante " + becaAplicanteListOrphanCheckBecaAplicante + " in its becaAplicanteList field has a non-nullable codbeca field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(becaa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Becaa> findBecaaEntities() {
        return findBecaaEntities(true, -1, -1);
    }

    public List<Becaa> findBecaaEntities(int maxResults, int firstResult) {
        return findBecaaEntities(false, maxResults, firstResult);
    }

    private List<Becaa> findBecaaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Becaa.class));
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

    public Becaa findBecaa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Becaa.class, id);
        } finally {
            em.close();
        }
    }

    public int getBecaaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Becaa> rt = cq.from(Becaa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
