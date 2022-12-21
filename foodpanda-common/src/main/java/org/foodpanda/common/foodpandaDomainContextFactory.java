/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.common;

import org.tentackle.common.Service;
import org.tentackle.pdo.DomainContext;
import org.tentackle.pdo.DomainContextFactory;
import org.tentackle.session.Session;

/**
 * Application specific domain context factory.
 */
@Service(DomainContextFactory.class)
public class foodpandaDomainContextFactory implements DomainContextFactory {

  @Override
  public DomainContext create(Session session) {
    return new foodpandaDomainContext(session);
  }

  @Override
  public DomainContext create(Session session, boolean sessionImmutable) {
    return new foodpandaDomainContext(session, sessionImmutable);
  }

}