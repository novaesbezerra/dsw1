package br.ufscar.dc.dsw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CidadesRSApplication {

	/*
	
	private static final Logger log = LoggerFactory.getLogger(CidadesRSApplication.class);
	
	static Map<String, Estado> map = new HashMap<>();

	private static void populaEstados(IEstadoDAO dao) {
		String line;
		try {
			InputStream stream = new FileInputStream("./estados.txt");
			InputStreamReader isr = new InputStreamReader(stream);
			BufferedReader reader = new BufferedReader(isr);
			line = reader.readLine();

			while (line != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");

				Estado estado = new Estado();
				String sigla = tokenizer.nextToken();
				estado.setSigla(sigla);
				estado.setNome(tokenizer.nextToken());
				dao.save(estado);

				map.put(sigla, estado);

				log.info("Salvo: " + estado);

				line = reader.readLine();
			}
			stream.close();
			isr.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void populaCidades(ICidadeDAO dao) {

		String line;
		String nome;
		Estado estado;
		String sigla;

		try {
			InputStream stream = new FileInputStream("./cidades.txt");
			InputStreamReader isr = new InputStreamReader(stream);
			BufferedReader reader = new BufferedReader(isr);

			line = reader.readLine();

			while (line != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				sigla = tokenizer.nextToken();
				sigla = sigla.substring(1, 3);
				nome = tokenizer.nextToken();
				nome = nome.substring(1, nome.length() - 1);
				estado = map.get(sigla);
				Cidade cidade = new Cidade();
				cidade.setNome(nome);
				cidade.setEstado(estado);
				dao.save(cidade);
				log.info("Salvo: " + cidade);
				line = reader.readLine();
			}
			stream.close();
			isr.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(CidadesRSApplication.class, args);
	}

	/*
	@Bean
	public CommandLineRunner run(IEstadoDAO estadoDAO, ICidadeDAO cidadeDAO) throws Exception {
		return args -> {
			populaEstados(estadoDAO);
			populaCidades(cidadeDAO);
		};
	}
	*/
}
