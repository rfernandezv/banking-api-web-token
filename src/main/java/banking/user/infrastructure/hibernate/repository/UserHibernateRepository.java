package banking.user.infrastructure.hibernate.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import banking.common.infrastructure.hibernate.repository.BaseHibernateRepository;
import banking.user.domain.entity.User;
import banking.user.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Repository
public class UserHibernateRepository extends BaseHibernateRepository<User>
		implements UserRepository {
	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		Criteria criteria = getSessionLogin().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}


	public void save(User user) {
		super.save(user);
	}
}
