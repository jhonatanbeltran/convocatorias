/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import DTO.Aplicante;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DTO.BecaAplicante;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author german
 */
public class AplicanteJpaController implements Serializable {

    public AplicanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aplicante aplicante) throws PreexistingEntityException, Exception {
        if (aplicante.getBecaAplicanteList() == null) {
            aplicante.setBecaAplicanteList(new ArrayList<BecaAplicante>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<BecaAplicante> attachedBecaAplicanteList = new ArrayList<BecaAplicante>();
            for (BecaAplicante becaAplicanteListBecaAplicanteToAttach : aplicante.getBecaAplicanteList()) {
                becaAplicanteListBecaAplicanteToAttach = em.getReference(becaAplicanteListBecaAplicanteToAttach.getClass(), becaAplicanteListBecaAplicanteToAttach.getCodigo());
                attachedBecaAplicanteList.add(becaAplicanteListBecaAplicanteToAttach);
            }
            aplicante.setBecaAplicanteList(attachedBecaAplicanteList);
            em.persist(aplicante);
            for (BecaAplicante becaAplicanteListBecaAplicante : aplicante.getBecaAplicanteList()) {
                Aplicante oldCodaplicanteOfBecaAplicanteListBecaAplicante = becaAplicanteListBecaAplicante.getCodaplicante();
                becaAplicanteListBecaAplicante.setCodaplicante(aplicante);
                becaAplicanteListBecaAplicante = em.merge(becaAplicanteListBecaAplicante);
                if (oldCodaplicanteOfBecaAplicanteListBecaAplicante != null) {
                    oldCodaplicanteOfBecaAplicanteListBecaAplicante.getBecaAplicanteList().remove(becaAplicanteListBecaAplicante);
                    oldCodaplicanteOfBecaAplicanteListBecaAplicante = em.merge(oldCodaplicanteOfBecaAplicanteListBecaAplicante);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAplicante(aplicante.getCedula()) != null) {
                throw new PreexistingEntityException("Aplicante " + aplicante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aplicante aplicante) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aplicante persistentAplicante = em.find(Aplicante.class, aplicante.getCedula());
            List<BecaAplicante> becaAplicanteListOld = persistentAplicante.getBecaAplicanteList();
            List<BecaAplicante> becaAplicanteListNew = aplicante.getBecaAplicanteList();
            List<String> illegalOrphanMessages = null;
            for (BecaAplicante becaAplicanteListOldBecaAplicante : becaAplicanteListOld) {
                if (!becaAplicanteListNew.contains(becaAplicanteListOldBecaAplicante)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain BecaAplicante " + becaAplicanteListOldBecaAplicante + " since its codaplicante field is not nullable.");
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
            aplicante.setBecaAplicanteList(becaAplicanteListNew);
            aplicante = em.merge(aplicante);
            for (BecaAplicante becaAplicanteListNewBecaAplicante : becaAplicanteListNew) {
                if (!becaAplicanteListOld.contains(becaAplicanteListNewBecaAplicante)) {
                    Aplicante oldCodaplicanteOfBecaAplicanteListNewBecaAplicante = becaAplicanteListNewBecaAplicante.getCodaplicante();
                    becaAplicanteListNewBecaAplicante.setCodaplicante(aplicante);
                    becaAplicanteListNewBecaAplicante = em.merge(becaAplicanteListNewBecaAplicante);
                    if (oldCodaplicanteOfBecaAplicanteListNewBecaAplicante != null && !oldCodaplicanteOfBecaAplicanteListNewBecaAplicante.equals(aplicante)) {
                        oldCodaplicanteOfBecaAplicanteListNewBecaAplicante.getBecaAplicanteList().remove(becaAplicanteListNewBecaAplicante);
                        oldCodaplicanteOfBecaAplicanteListNewBecaAplicante = em.merge(oldCodaplicanteOfBecaAplicanteListNewBecaAplicante);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = aplicante.getCedula();
                if (findAplicante(id) == null) {
                    throw new NonexistentEntityException("The aplicante with id " + id + " no longer exists.");
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
            Aplicante aplicante;
            try {
                aplicante = em.getReference(Aplicante.class, id);
                aplicante.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aplicante with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<BecaAplicante> becaAplicanteListOrphanCheck = aplicante.getBecaAplicanteList();
            for (BecaAplicante becaAplicanteListOrphanCheckBecaAplicante : becaAplicanteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Aplicante (" + aplicante + ") cannot be destroyed since the BecaAplicante " + becaAplicanteListOrphanCheckBecaAplicante + " in its becaAplicanteList field has a non-nullable codaplicante field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(aplicante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aplicante> findAplicanteEntities() {
        return findAplicanteEntities(true, -1, -1);
    }

    public List<Aplicante> findAplicanteEntities(int maxResults, int firstResult) {
        return findAplicanteEntities(false, maxResults, firstResult);
    }

    private List<Aplicante> findAplicanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aplicante.class));
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

    public Aplicante findAplicante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aplicante.class, id);
        } finally {
            em.close();
        }
    }

    public int getAplicanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aplicante> rt = cq.from(Aplicante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
