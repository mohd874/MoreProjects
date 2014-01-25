package ae.iemq.vims.util;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.log4j.Logger;

public class LDAPUtil {
	
	static Logger LOG = Logger.getLogger(LDAPUtil.class);
	
	static final String ROLE_ADMIN = "admin";
	
	static final String ROLE_USER = "user";
	
	static final String ROLE_DELETER = "deleter";
	
	DirContext dirContext;
	
	String rolesContextOU; //"ou=roles"
	
	String peopleContextOU; //"ou=people"
	
	String peopleSearchFilter; //"(objectClass={0})"
	
	String peopleFileterArg; //"person"
	
	String peopleUID;// uid
	
	String groupNamePrototype;
	
	String userUniquePrototype;
	
	String groupMemberKey;	// uniquemember
	
	String groupSearchFilter; //"(uniqueMember={0})"
	
	String roleCnFilter; // cn={0},ou=roles
	
	String userFilter; // "uid={0},ou=People,dc=iemq,dc=ae"
	
	
	private List<String> getAllNonUsers() {
		SearchControls ctls1 = new SearchControls();
		ctls1.setSearchScope(1);
		ctls1.setTimeLimit(0);
		ctls1.setDerefLinkFlag(false);
		// ctls1.setReturningAttributes(new String[] {"uid","userPassword"});
		ctls1.setReturningAttributes(new String[] { peopleUID });
		List<String> userIdList = new ArrayList<String>();
		try {
			// NamingEnumeration<SearchResult> matchingEntries =
			// dirContext.search("ou=people",
			//					"(objectClass={0})", new String[] { "person" }, ctls1);
			NamingEnumeration<SearchResult> matchingEntries = dirContext.search(peopleContextOU,
					peopleSearchFilter, new String[] { peopleFileterArg }, ctls1);
			while (matchingEntries.hasMore()) {
				SearchResult result = (SearchResult) matchingEntries.next();
				Attributes attrs = result.getAttributes();
				userIdList.add(attrs.get(peopleUID).get().toString());
			}
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		LOG.info(userIdList);
		ctls1 = new SearchControls();
		userIdList.removeAll(getRoleUsers(ROLE_ADMIN));
		userIdList.removeAll(getRoleUsers(ROLE_USER));
		userIdList.removeAll(getRoleUsers(ROLE_DELETER));
		LOG.info("final users" + userIdList);
		if (!userIdList.isEmpty()) {
			addVimsUser("cn=user,ou=roles", "uid=" + userIdList.get(0)
					+ ",ou=People,dc=iemq,dc=ae");
			LOG.info(getRoleUsers("user"));
			deleteVimsUser("cn=user,ou=roles", "uid=" + userIdList.get(0)
					+ ",ou=People,dc=iemq,dc=ae");
			LOG.info(getRoleUsers("user"));
		}
		return userIdList;
	}

	private List getRoleUsers(String roleName) {
		SearchControls searchControls = new SearchControls();
		searchControls.setSearchScope(1);
		searchControls.setTimeLimit(0);
		searchControls.setDerefLinkFlag(false);
		// ctls1.setReturningAttributes(new String[] {"uid","userPassword"});
		searchControls.setReturningAttributes(new String[] { groupMemberKey });
		List userIdList = new ArrayList();
		try {
			NamingEnumeration matchingEntries = getDirContext().search(rolesContextOU,
					"(cn={0})", new String[] { roleName }, searchControls);
			while (matchingEntries.hasMore()) {
				SearchResult result = (SearchResult) matchingEntries.next();
				Attributes attrs = result.getAttributes();
				// LOG.info("attrs = "+attrs);
				NamingEnumeration enumeration = attrs.getAll();
				while (enumeration.hasMore()) {
					Attribute attribute = (Attribute) enumeration.next();
					NamingEnumeration uniqueMembers = attribute.getAll();
					while (uniqueMembers.hasMoreElements()) {
						userIdList.add(uniqueMembers.nextElement().toString()
								.split(",")[0].split("=")[1]);
					}
				}
			}
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		LOG.info(userIdList);
		return userIdList;
	}

	private void addVimsUser(String groupName, String uid) {
		ModificationItem member[] = new ModificationItem[1];
		member[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE,
				new BasicAttribute(groupMemberKey, uid));

		try {
			getDirContext().modifyAttributes(groupName, member);
		} catch (NamingException e) {
			e.printStackTrace();
			LOG.info(e.getMessage());
		}
		LOG.info("Added user to group: " + groupName);
	}

	public void deleteVimsUser(String groupName,
			String uid) {
		ModificationItem member[] = new ModificationItem[1];
		member[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE,
				new BasicAttribute(groupMemberKey, uid));

		try {
			getDirContext().modifyAttributes(groupName, member);
		} catch (NamingException e) {
			e.printStackTrace();
			LOG.info(e.getMessage());
		}
		LOG.info("deleted user from group: " + groupName);
	}
	
	public List getAllRoles(String userId) {
		SearchControls ctls1 = new SearchControls();
		ctls1.setSearchScope(1);
		ctls1.setTimeLimit(0);
		ctls1.setDerefLinkFlag(false);
		ctls1.setReturningAttributes(new String[] {"cn"});
		List userRoleList = new ArrayList();
		try {
			NamingEnumeration matchingEntries = getDirContext().search(rolesContextOU, groupSearchFilter, new String[]{"uid="+userId+",ou=People,dc=iemq,dc=ae",userId},ctls1);
			 while (matchingEntries.hasMore()) {
                 SearchResult result = (SearchResult) matchingEntries.next();
                 Attributes attrs = result.getAttributes();
                 userRoleList.add(attrs.get("cn").get(attrs.get("cn").size()-1));
             }
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		LOG.info(userRoleList);
		return userRoleList;
		
	}

	public DirContext getDirContext() {
		return dirContext;
	}

	public void setDirContext(DirContext dirContext) {
		this.dirContext = dirContext;
	}

	public String getRolesContextOU() {
		return rolesContextOU;
	}

	public void setRolesContextOU(String rolesContextOU) {
		this.rolesContextOU = rolesContextOU;
	}

	public String getPeopleContextOU() {
		return peopleContextOU;
	}

	public void setPeopleContextOU(String peopleContextOU) {
		this.peopleContextOU = peopleContextOU;
	}

	public String getPeopleSearchFilter() {
		return peopleSearchFilter;
	}

	public void setPeopleSearchFilter(String peopleSearchFilter) {
		this.peopleSearchFilter = peopleSearchFilter;
	}

	public String getPeopleFileterArg() {
		return peopleFileterArg;
	}

	public void setPeopleFileterArg(String peopleFileterArg) {
		this.peopleFileterArg = peopleFileterArg;
	}

	public String getPeopleUID() {
		return peopleUID;
	}

	public void setPeopleUID(String peopleUID) {
		this.peopleUID = peopleUID;
	}

	public String getGroupNamePrototype() {
		return groupNamePrototype;
	}

	public void setGroupNamePrototype(String groupNamePrototype) {
		this.groupNamePrototype = groupNamePrototype;
	}

	public String getUserUniquePrototype() {
		return userUniquePrototype;
	}

	public void setUserUniquePrototype(String userUniquePrototype) {
		this.userUniquePrototype = userUniquePrototype;
	}

	public String getGroupMemberKey() {
		return groupMemberKey;
	}

	public void setGroupMemberKey(String groupMemberKey) {
		this.groupMemberKey = groupMemberKey;
	}

	public String getGroupSearchFilter() {
		return groupSearchFilter;
	}

	public void setGroupSearchFilter(String groupSearchFilter) {
		this.groupSearchFilter = groupSearchFilter;
	}

}
