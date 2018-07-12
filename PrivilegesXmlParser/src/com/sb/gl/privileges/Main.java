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
import java.util.TreeMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

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

	private void manifests() {
		try {
			Map<String, List<Privilege>> map = getManifests();
//			System.out.println("-----------------------------------------------------");
			Set<String> set = map.keySet();
			for (String key : set) {
				List<Privilege> privs = map.get(key);
				if (privs == null) {
//					System.out.println("No privileges used");
					continue;
				}
				System.out.println("https://cs.corp.google.com/piper///depot/" + key.substring(key.indexOf("google3"))
						+ "?q=PrivilegesSchema");
				String s = key.substring(0, key.indexOf(suffix) - 1);
				s = s.substring(s.lastIndexOf('/') + 1);
				System.out.println(s);
				for (Privilege privilege : privs) {
					System.out.println("\t" + privilege);
				}
			}
		} catch (IOException | JAXBException | XMLStreamException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.manifests();
	}
}
