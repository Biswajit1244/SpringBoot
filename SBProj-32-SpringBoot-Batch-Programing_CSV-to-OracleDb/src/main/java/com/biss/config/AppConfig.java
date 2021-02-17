package com.biss.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.biss.model.Product;
import com.biss.processor.MyProdProcessor;

@Configuration
@EnableBatchProcessing
public class AppConfig {
	@Autowired
	private JobBuilderFactory jf;
	@Autowired
	private StepBuilderFactory sf;
	
	@Bean
	public Job jobA() {
		return  jf.get("jobA")
				.incrementer(new RunIdIncrementer())
				.start(stepA())
				.build();
	}
	@Bean
	public Step stepA() {
		return sf.get("stepA")
				 .<Product,Product>chunk(1)
				 .reader(reader())
				 .processor(processor())
				 .writer(writer())
				 .build();
	}
	//1.ItemReader
	@Bean
	public ItemReader<Product> reader(){
		FlatFileItemReader<Product> reader=new FlatFileItemReader<Product>();
		reader.setResource(new ClassPathResource("product.csv"));
		reader.setLineMapper(new DefaultLineMapper<Product>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setNames("prodId","prodCode","prodCost");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {{
				setTargetType(Product.class);
			}});
		}});
		return reader;
	}
	//2.ItemProcessor
	@Bean
	public ItemProcessor<Product,Product> processor(){
		return new MyProdProcessor();
	}
	//3.ItemWriter
	@Bean
	public ItemWriter<Product> writer(){
		JdbcBatchItemWriter<Product> writer=new JdbcBatchItemWriter<Product>();
		writer.setDataSource(dataSource());
		writer.setSql("INSERT INTO PRODTAB(PID,PCODE,PCOST,PGST,PDIST) VALUES(:prodId,:prodCode,:prodCost,:gst,:discount)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Product>());
		return writer;
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		ds.setUsername("scott");
		ds.setPassword("djbravo");
		return ds;
	}
	
}
