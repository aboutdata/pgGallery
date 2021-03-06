package installer.parts;

import installer.Part;

import java.sql.Connection;
import java.util.Map;

public class InstallerInstaller extends Part {

	public InstallerInstaller(Connection conn) {
		super(conn);
	}
	
	@Override
	public long priority() {
		return 0;
	}

	@Override
	public boolean isInstalled() throws Exception {
		Map<String, Object> row = this.sqlRunner.selectOne("SELECT count(*) as count FROM pg_tables WHERE tablename='pgGalleryInstaller'");
		long count = (Long) row.get("COUNT");
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	protected void preinstall() {}
	
	@Override
	protected void postinstall() {}
}
