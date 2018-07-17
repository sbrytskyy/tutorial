package com.sb.gl.privileges;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

import com.sb.gl.privileges.Main.Counters;

public class Main {

	private static class XsiTypeReader extends StreamReaderDelegate {
		public XsiTypeReader(XMLStreamReader reader) {
			super(reader);
		}

		@Override
		public String getNamespaceURI() {
			return "";
		}
	}

	private static final String suffix = "prod/manifest.xml";
	String path2manifests = "/google/src/cloud/sbrytskyy/privs/google3/apps/extensibility/packaging/manifests";

	String path2robots = "/google/src/cloud/sbrytskyy/privs/google3/ccc/hosted/production/liveconfig/authz/dasher-authz.robot_account_config.gcl";

	private Map<String, List<Privilege>> getManifests() throws IOException, JAXBException, XMLStreamException {
		Path dir = Paths.get(path2manifests);
		List<String> fileNames = new ArrayList<>();
		getFileNames(fileNames, dir);

		Map<String, List<Privilege>> map = new TreeMap<>();

		for (String filename : fileNames) {
			List<Privilege> manifest = parseManifest(filename);
			map.put(filename, manifest);
		}
		return map;
	}

	private List<String> getFileNames(List<String> fileNames, Path dir) {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path path : stream) {
				if (path.toFile().isDirectory()) {
					getFileNames(fileNames, path);
				} else {
					if (path.endsWith(suffix)) {
						fileNames.add(path.toAbsolutePath().toString());
//						System.out.println(path);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileNames;
	}

	private List<Privilege> parseManifest(String filename)
			throws JAXBException, FileNotFoundException, XMLStreamException {

		XMLInputFactory xif = XMLInputFactory.newFactory();
		XMLStreamReader xsr = xif.createXMLStreamReader(new FileInputStream(filename));
		xsr = new XsiTypeReader(xsr);

		JAXBContext jaxbContext = JAXBContext.newInstance(ApplicationManifest.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		ApplicationManifest appManifest = (ApplicationManifest) jaxbUnmarshaller.unmarshal(xsr);

		PrivilegesSchema privilegesSchema = appManifest.getPrivilegesSchema();
		if (privilegesSchema == null) {
			return null;
		}
		List<Privilege> privileges = privilegesSchema.getPrivileges();
//		for (Privilege privilege : privileges) {
//			System.out.println(privilege);
//		}

		return privileges;
	}
	
	class Counters {
		String delegated = "";
		String robot = "";
		String domain = "";
		String reseller = "";
		String support = "";
	}

	public void manifests() {
		try {
			Map<String, Map<String, Counters>> counts = counts();
			Map<String, List<Privilege>> map = getManifests();
//			System.out.println("-----------------------------------------------------");
			Set<String> set = map.keySet();
			for (String key : set) {
				List<Privilege> privs = map.get(key);
				if (privs == null) {
//					System.out.println("No privileges used");
					continue;
				}
				String serviceName = key.substring(0, key.indexOf(suffix) - 1);
				serviceName = serviceName.substring(serviceName.lastIndexOf('/') + 1);
				System.out.println(serviceName);

				String url = "https://cs.corp.google.com/piper///depot/" + key.substring(key.indexOf("google3"))
						+ "?q=PrivilegesSchema";
				System.out.println(url);
				for (Privilege privilege : privs) {
					System.out.print("\t" + privilege);
					Map<String, Counters> map0 = counts.get(serviceName);
					if (map0 != null) {
						Counters counters = map0.get(privilege.getId());
						if (counters != null) {
							System.out.print("\t" + counters.delegated
									+ "\t" + counters.robot
									+ "\t" + counters.domain
									+ "\t" + counters.reseller
									+ "\t" + counters.support);
						}
					}
					System.out.println();
				}
			}
		} catch (IOException | JAXBException | XMLStreamException e) {
			e.printStackTrace();
		}
	}

	private Map<String, Map<String, Counters>> counts() {
		Map<String, Map<String, Counters>> map = new HashMap<>();
		try (Stream<String> stream = Files.lines(Paths.get("counter.csv"))) {
			stream.forEach(s -> {
				if (s.charAt(0) != '\t') {
					StringTokenizer st = new StringTokenizer(s, "\t");
					String serviceName = st.nextToken();
					Map<String, Counters> map0 = map.getOrDefault(serviceName, new HashMap<>());
					String priviledge = st.nextToken();
					Counters counters = map0.getOrDefault(priviledge, new Counters());
					String authorizer = st.nextToken();
					st.nextToken();
					String sCount = st.nextToken();

					if ("DOMAIN_ADMIN".equals(authorizer)) {
						counters.domain = sCount;
					} else if ("ROBOT_ACCOUNT".equals(authorizer)) {
						counters.robot = sCount;
					} else if ("DELEGATED_ADMIN".equals(authorizer)) {
						counters.delegated = sCount;
					} else if ("RESELLER".equals(authorizer)) {
						counters.reseller = sCount;
					} else if ("SUPPORT_USER".equals(authorizer)) {
						counters.support = sCount;
					}
					map0.put(priviledge, counters);
					map.put(serviceName, map0);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.manifests();
	}
}
